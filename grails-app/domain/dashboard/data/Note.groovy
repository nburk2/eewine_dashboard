package dashboard.data

class Note {

    String message
    MessageType messageType = MessageType.INFORMATIVE
    Date useFrom = new Date().clearTime()
    Date useTo = (new Date() + 1).clearTime()

    enum MessageType {
        INFORMATIVE("Informative"),
        SUCCESS("Success"),
        WARNING("Warning"),
        ERROR("Error")

        String prettyName

        MessageType(String prettyName){
            this.prettyName = prettyName
        }
    }

    static constraints = {
        message         nullable: false, maxSize: 255
        messageType     nullable: false
        useFrom         nullable: false
        useTo           nullable: false
    }
}
