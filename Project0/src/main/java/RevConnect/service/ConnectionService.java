package RevConnect.service;

import RevConnect.dao.ConnectionDAOImp;
import RevConnect.CustomExceptions.*;

public class ConnectionService {

    ConnectionDAOImp dao = new ConnectionDAOImp();

    public String sendRequest(int senderId, int receiverId) throws ConnectionAlreadyExistsException, InvalidConnectionRequestException {

        try{
            if(senderId==receiverId) {
                throw new InvalidConnectionRequestException("Cannot connect with the same ID's");
            }

            if(dao.requestExists(senderId,receiverId)){
                throw new ConnectionAlreadyExistsException("Request already sent");
            }

            dao.sendRequest(senderId, receiverId);
            return "Connection request sent";

        } catch (ConnectionAlreadyExistsException | InvalidConnectionRequestException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending request!";
        }
    }

    public String acceptRequest(int senderId, int receiverId) throws ConnectionNotFoundException {

        try {
            if(!dao.connectionExists(senderId,receiverId)){
                throw new ConnectionNotFoundException("Request not found");
            }

            dao.updateStatus(senderId, receiverId, "ACCEPTED");
            return "Connection accepted";

        } catch (ConnectionNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error accepting request";
        }
    }

    public String rejectRequest(int senderId, int receiverId) throws ConnectionNotFoundException {

        try {
            if (!dao.connectionExists(senderId, receiverId)) {
                throw new ConnectionNotFoundException("Request not found");
            }
            dao.updateStatus(senderId, receiverId, "REJECTED");
            return "Request rejected";

        } catch (ConnectionNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error rejecting request";
        }
    }
}