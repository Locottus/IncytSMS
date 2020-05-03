package herlich.gonzalez.incytsms;


//modelo del mensaje sms a enviar
public class SMS {
    private String _id;
    private String thread_id;
    private String toa;
    private String address;
    private String person;
    private String date;
    private String date_sent;
    private String protocol;
    private String read;
    private String status;
    private String type;
    private String reply_path_present;
    private String subject;
    private String body;
    private String sc_toa;
    private String report_date;
    private String service_center;
    private String locked;
    private String sub_id;
    private String index_on_sim;
    private String callback_number;
    private String priority;
    private String htc_category;
    private String cs_timestamp;
    private String cs_id;
    private String cs_synced;
    private String error_code;
    private String creator;
    private String seen;
    private String is_cdma_format;
    private String is_evdo;
    private String c_type;
    private String exp;
    private String gid;
    private String extra;
    private String date2;
    private String sim_slot;


    public SMS(String _id, String thread_id, String toa, String address, String person, String date, String date_sent, String protocol, String read, String status, String type, String reply_path_present, String subject, String body, String sc_toa, String report_date, String service_center, String locked, String sub_id, String index_on_sim, String callback_number, String priority, String htc_category, String cs_timestamp, String cs_id, String cs_synced, String error_code, String creator, String seen, String is_cdma_format, String is_evdo, String c_type, String exp, String gid, String extra, String date2, String sim_slot) {
        this._id = _id;
        this.thread_id = thread_id;
        this.toa = toa;
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
        this.sc_toa = sc_toa;
        this.report_date = report_date;
        this.service_center = service_center;
        this.locked = locked;
        this.sub_id = sub_id;
        this.index_on_sim = index_on_sim;
        this.callback_number = callback_number;
        this.priority = priority;
        this.htc_category = htc_category;
        this.cs_timestamp = cs_timestamp;
        this.cs_id = cs_id;
        this.cs_synced = cs_synced;
        this.error_code = error_code;
        this.creator = creator;
        this.seen = seen;
        this.is_cdma_format = is_cdma_format;
        this.is_evdo = is_evdo;
        this.c_type = c_type;
        this.exp = exp;
        this.gid = gid;
        this.extra = extra;
        this.date2 = date2;
        this.sim_slot = sim_slot;
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

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
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

    public String getSc_toa() {
        return sc_toa;
    }

    public void setSc_toa(String sc_toa) {
        this.sc_toa = sc_toa;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
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

    public String getIndex_on_sim() {
        return index_on_sim;
    }

    public void setIndex_on_sim(String index_on_sim) {
        this.index_on_sim = index_on_sim;
    }

    public String getCallback_number() {
        return callback_number;
    }

    public void setCallback_number(String callback_number) {
        this.callback_number = callback_number;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getHtc_category() {
        return htc_category;
    }

    public void setHtc_category(String htc_category) {
        this.htc_category = htc_category;
    }

    public String getCs_timestamp() {
        return cs_timestamp;
    }

    public void setCs_timestamp(String cs_timestamp) {
        this.cs_timestamp = cs_timestamp;
    }

    public String getCs_id() {
        return cs_id;
    }

    public void setCs_id(String cs_id) {
        this.cs_id = cs_id;
    }

    public String getCs_synced() {
        return cs_synced;
    }

    public void setCs_synced(String cs_synced) {
        this.cs_synced = cs_synced;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

    public String getIs_cdma_format() {
        return is_cdma_format;
    }

    public void setIs_cdma_format(String is_cdma_format) {
        this.is_cdma_format = is_cdma_format;
    }

    public String getIs_evdo() {
        return is_evdo;
    }

    public void setIs_evdo(String is_evdo) {
        this.is_evdo = is_evdo;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getSim_slot() {
        return sim_slot;
    }

    public void setSim_slot(String sim_slot) {
        this.sim_slot = sim_slot;
    }
}
