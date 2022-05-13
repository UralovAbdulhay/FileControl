package uz.tatu.filecontrol.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import uz.tatu.filecontrol.entity.util.FileType;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Subject {


    @Id
    Integer id;

    @OneToMany(mappedBy = "subject")
    List<FileContent> fileContents;

    @ManyToOne
    Department department;

    String name;


    @Transient
    List<FileContent> lectures;

    @Transient
    List<FileContent> practises;

    @Transient
    List<FileContent> laboratories;

    @Transient
    List<FileContent> others;




    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFileContents(List<FileContent> fileContents) {
        this.fileContents = fileContents;
    }

    public List<FileContent> addContent(FileContent fileContent) {
        this.fileContents.add(fileContent);
        switch (fileContent.getType()) {
            case LECTURE:
                addLecture(fileContent);
                break;
            case LABORATORY:
                addLaboratory(fileContent);
                break;
            case PRACTICE:
                addPractise(fileContent);
                break;
            default:
                addOthers(fileContent);
        }
        return this.fileContents;
    }


    public List<FileContent> getLectures() {
        if (this.lectures != null) {
            return lectures;
        } else {
            lectures = fileContents.stream().filter(e -> e.getType() == FileType.LECTURE).collect(Collectors.toList());
            return lectures;
        }
    }

    public List<FileContent> getPractises() {
        if (this.practises != null) {
            return practises;
        } else {
            practises = fileContents.stream().filter(e -> e.getType() == FileType.PRACTICE).collect(Collectors.toList());
            return practises;
        }
    }

    public List<FileContent> getLaboratories() {
        if (this.laboratories != null) {
            return laboratories;
        } else {
            laboratories = fileContents.stream().filter(e -> e.getType() == FileType.LABORATORY).collect(Collectors.toList());
            return laboratories;
        }
    }

    public List<FileContent> getOthers() {
        if (this.others != null) {
            return others;
        } else {
            others = fileContents.stream().filter(e -> e.getType() == FileType.OTHER).collect(Collectors.toList());
            return others;
        }
    }


    private void addLecture(FileContent fileContent) {
        getLectures().add(fileContent);
    }

    private void addPractise(FileContent fileContent) {
        getPractises().add(fileContent);
    }

    private void addLaboratory(FileContent fileContent) {
        getLaboratories().add(fileContent);
    }

    private void addOthers(FileContent fileContent) {
        getOthers().add(fileContent);
    }

}
