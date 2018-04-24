package com.du.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author duqifeng
 * 2018/4/20 16:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    private String id;
    private String name;
    private String title;
    private String description;
}
