package com.example.Test07;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UpdateForm {
    @NotBlank(message = "Nullもしくは空白文字です。")
    @Length(min = 1, max = 19, message = "20文字未満で入力してください。")
    private String name;  //名前
    private String birthday;  //生年月日
    private String club;  //所属部活

    public UpdateForm(String name, String birthday, String club) {
        this.name = name;
        this.birthday = birthday;
        this.club = club;
    }
}
