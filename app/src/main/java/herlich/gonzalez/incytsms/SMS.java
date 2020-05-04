package herlich.gonzalez.incytsms;


//modelo del mensaje sms a enviar
public class SMS {
    private String _id;//
    private String thread_id;//
    private String address;//
    private String person;//
    private String date;//
    private String date_sent;//
    private String protocol;//
    private String read;//
    private String status;//
    private String type;//
    private String reply_path_present;//
    private String subject;//
    private String body;//
    private String service_center;//
    private String locked;//
    private String sub_id;//
    private String callback_number;//
    private String error_code;//

    public SMS(String _id, String thread_id, String address, String person, String date, String date_sent, String protocol, String read, String status, String type, String reply_path_present, String subject, String body, String service_center, String locked, String sub_id, String callback_number, String error_code) {
        this._id = _id;
        this.thread_id = thread_id;
        this.address = address;
        this.person = person;
        this.date = date;
        this.date_sent = date_sent;
        this.protocol = protocol;
        this.read = read;
        this.status = status;
        this.type = type;
        this.reply_path_present = reply_path_present;
        this.subject = subject;
        this.body = body;
        this.service_center = service_center;
        this.locked = locked;
        this.sub_id = sub_id;
        this.callback_number = callback_number;
        this.error_code = error_code;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_sent() {
        return date_sent;
    }

    public void setDate_sent(String date_sent) {
        this.date_sent = date_sent;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReply_path_present() {
        return reply_path_present;
    }

    public void setReply_path_present(String reply_path_present) {
        this.reply_path_present = reply_path_present;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getService_center() {
        return service_center;
    }

    public void setService_center(String service_center) {
        this.service_center = service_center;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getCallback_number() {
        return callback_number;
    }

    public void setCallback_number(String callback_number) {
        this.callback_number = callback_number;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public SMS() {
    }
}
