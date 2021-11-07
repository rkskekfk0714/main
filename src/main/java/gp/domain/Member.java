package gp.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)

    private String password;

    @Column(length = 30, nullable = true)
    private String name;

    @Column(length = 50, nullable = true)
    private String address;

    @Column(length = 45, nullable = true)
    private String date;

    @Column(length = 5, nullable = true)
    private String gender;


    @Column(length = 20, nullable = false)

    private String phone;

    @Column(length = 50, nullable = true)
    private String email;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_dated;

    public Long getId(){
        return id;
    }

    @Builder
    public Member(Long id, String username, String password, String name, String address, String date, String gender, String phone, String email, Date create_dated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.date = date;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.create_dated = create_dated;
    }


    public boolean matchId(Long newId) {
        if ( newId == null ) {
            return false;
        }
        return newId.equals(getUsername());
    }

    public boolean matchPassword(String newPassword) {
        if ( newPassword == null ) {
            return false;
        }
        return newPassword.equals(password);
    }
    public void update(Member updateduser){
        this.password=updateduser.password;
    }
}
