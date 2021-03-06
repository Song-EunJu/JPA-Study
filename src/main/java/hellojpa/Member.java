package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // jpa를 사용하는 애구나 라고 jpa가 인식
public class Member {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
