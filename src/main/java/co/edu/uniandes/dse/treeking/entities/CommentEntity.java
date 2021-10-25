package co.edu.uniandes.dse.treeking.entities;

import co.edu.uniandes.dse.treeking.podam.DateStrategy;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class CommentEntity extends BaseEntity{

    private String text;
    private Integer likes;
    private Integer dislikes;

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date date;

    @PodamExclude
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CommentEntity> comments;

    @PodamExclude
    @ManyToOne
    @JoinColumn
    private CommentEntity comment;

    @PodamExclude
    @ManyToOne
    private UserEntity user;

}
