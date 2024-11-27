package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is mandatory!!")
    private String name;

    @Email
    @NotBlank(message = "Email is Must!!")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is Must!!")
    private String password;

    // Args Constructor
    public User(String name , String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
