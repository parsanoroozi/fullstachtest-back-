package test.project.back.model;
import jakarta.persistence.*;
@Entity
@Table(name= "testtable")
public class KeyValueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="keyy")
    private String key;

    @Column(name="valuee")
    private String value;

    public KeyValueModel(){}

    public KeyValueModel(String key, String value){
        this.key = key;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
