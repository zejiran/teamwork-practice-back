package co.edu.uniandes.dse.treeking.entities;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class BlogEntity extends BaseEntity{
    @PodamExclude
	  @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)  
    private ArrayList<PostEntity> blogPosts
}