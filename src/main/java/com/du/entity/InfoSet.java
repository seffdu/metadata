package com.du.entity;

import com.du.annotation.MongoGeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @author duqifeng
 * 2018/4/24 18:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoSet implements Serializable {
    @Id
    @MongoGeneratedValue
    private Long id;
    private String setId;
    private String setName;
    private Integer logicId;
    private String remark;
    private String codeOrder;
    private Integer creator;
    private String whoModified;
    private Date createdTime;
    private Date modifiedTime;
}
