package mum.edu.se.coursework.carrental.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "USER")
@Data
public class User {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotEmpty(message = "*Please provide your name")
    @Column(name = "FULL_NAME")
    private String fullName;

    @Length(min = 5, message = "*Your password must have at least 6 characters")
    @NotEmpty(message = "*Please provide your password")

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "FB_ID")
    private Long fbId;

    @Column(name = "TWITTER_ID")
    private Long twitterId;

    @Column(name = "PROFILE_PIC_URL")
    private String profilePicUrl;
    //active
    @Column(name = "ACTIVE")
    private Integer active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}
