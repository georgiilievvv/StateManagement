
public class HttpCookie {

    private String key;
    private String value;

    HttpCookie(String key, String value) {
        this.setKey(key);
        this.setValue(value);

    }

    private String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    private String getValue() {
        return value;
    }

    private void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getKey() + " <-> " + this.getValue();
    }
}
