package uz.tatu.filecontrol.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tatu.filecontrol.entity.util.FileType;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FileContent {

    @Id
    Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    MyFile myFile;

    @Column(columnDefinition = "TEXT")
    String content;

    @Column(columnDefinition = "TEXT")
    String title;

    @Enumerated(value = EnumType.STRING)
    FileType type;

    @ManyToOne
    Subject subject;

}
