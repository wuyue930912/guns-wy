package cn.stylefeng.guns;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import cn.stylefeng.guns.modular.system.model.User;
import cn.stylefeng.guns.modular.system.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket/{ro_user}")
@Component
public class WebSocketServer {

    @Autowired
    private IUserService userService;

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static final Map<Integer, CopyOnWriteArraySet<WebSocketServer>> rooms = new HashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private Integer roomId;

    private String userName;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "ro_user") String ro_user){
        this.session = session;
        String[] param = ro_user.split("-");
        this.roomId = Integer.parseInt(param[0]);
        this.userName = param[1];

        CopyOnWriteArraySet<WebSocketServer> friends = rooms.get(roomId);
        if (friends == null) {
            synchronized (rooms) {
                if (!rooms.containsKey(roomId)) {
                    friends = new CopyOnWriteArraySet<>();
                    rooms.put(roomId, friends);
                }
            }
        }
        friends.add(this);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        CopyOnWriteArraySet<WebSocketServer> friends = rooms.get(roomId);
        if (friends != null) {
            friends.remove(this);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //群发消息
        CopyOnWriteArraySet<WebSocketServer> friends = rooms.get(roomId);

        if (friends != null) {
            for (WebSocketServer item : friends) {
                item.session.getAsyncRemote().sendText(this.userName + ":::"  + format.format(new Date()) + ":" + message);
            }
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer .onlineCount--;
    }
}