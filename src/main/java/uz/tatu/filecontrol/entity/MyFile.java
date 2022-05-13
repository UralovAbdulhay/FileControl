package uz.tatu.filecontrol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyFile {

    @Id
    private String hashId;

    private String name;

    @JsonIgnore
    private String extension;

    @JsonIgnore
    private Long fileSize;

    @JsonIgnore
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.hibernate.type.ByteType")
    private byte[] data;

    @JsonIgnore
    private String uploadPath;

}
