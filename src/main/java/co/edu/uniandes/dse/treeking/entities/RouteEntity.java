package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.*;

import co.edu.uniandes.dse.treeking.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class RouteEntity extends BaseEntity {

    private Difficulty difficulty;
    private Integer estimatedDuration;

    @PodamExclude
    @OneToMany(mappedBy = "map", fetch = FetchType.LAZY)
    private List<LocationEntity> locationlist = new ArrayList<>();

    @PodamExclude
    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewlist = new ArrayList<>();

    @PodamExclude
    @OneToMany(mappedBy = "multimedia", fetch = FetchType.LAZY)
    private List<MultimediaEntity> multimedialist = new ArrayList<>();

    @PodamExclude
    @ManyToOne
    private OutingEntity outing;

}