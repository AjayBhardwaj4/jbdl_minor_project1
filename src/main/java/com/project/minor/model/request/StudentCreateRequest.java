package com.project.minor.model.request;

import com.project.minor.model.Student;
import com.project.minor.model.StudentAccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    private String address;
    private String email;

    public Student toStudent() {
        return Student.builder()
                .name(name)
                .address(address)
                .contact(contact)
                .address(address)
                .email(email)
                .accountStatus(StudentAccountStatus.ACTIVE)
                .build();
    }
}
