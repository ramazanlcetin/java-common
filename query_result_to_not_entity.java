import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.transform.Transformers;

@Service
@Transactional
public class EntityService {

	private static final long serialVersionUID = -5168864631867728930L;
	@Autowired   EntityManager em;
	
	/* Native query result map to not @Entity class */
	public List<EntityDTO> getEntityList() {
			String query=" SELECT id,name,description from tbl_entity "
			List<EntityDTO> dtoList = em.createNativeQuery(query.getQuery())
			        .unwrap(org.hibernate.Query.class).setResultTransformer(Transformers.aliasToBean(EntityDTO.class)).list();
			return dtoList;
		}

	/* not @Entity class */
	public class EntityDTO {
		private Integer id;
		private String name;
		private String description;

		public Integer getId() {
		    return id;
		}

		public void setId(Integer id) {
		    this.id = id;
		}

		public String getName() {
		    return name;
		}

		public void setName(String name) {
		    this.name = name;
		}

		public String getDescription() {
		return description;
		}

		public void setDescription(String description) {
		    this.description = description;
		}

	}

}
