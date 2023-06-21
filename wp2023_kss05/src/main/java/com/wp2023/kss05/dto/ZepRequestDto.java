package com.wp2023.kss05.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZepRequestDto {

    private Long cid;

    private String cvzepid;

    private String cvtime;

    private Long cvsuccessornot;

    // Getters and setters

}
