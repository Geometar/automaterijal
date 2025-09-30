package com.automaterijal.application.domain.dto.blog;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogCommentRequest {

  @NotBlank(message = "Author name is required")
  @Size(max = 120)
  String authorName;

  @Email(message = "Email must be valid")
  @Size(max = 180)
  String authorEmail;

  @NotBlank(message = "Comment content is required")
  @Size(min = 10, max = 2000, message = "Comment must be between 10 and 2000 characters")
  String content;
}
