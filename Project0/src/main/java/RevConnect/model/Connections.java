package RevConnect.model;

import java.util.Date;

public class Connections {

    private int connectionId;
    private int senderId;
    private int receiverId;
    private String status;
    private Date createdAt;

    public Connections(int senderId, int receiverId, String status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
    }


    public int getSenderId(){
        return senderId;
    }

    public int getReceiverId(){
        return receiverId;
    }

    public String getStatus(){
        return status;
    }

    public Date getCreatedAt(){
        return createdAt;
    }
}