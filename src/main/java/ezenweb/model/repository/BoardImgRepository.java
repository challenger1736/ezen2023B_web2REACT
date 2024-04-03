package ezenweb.model.repository;

import ezenweb.model.entity.BoardImgEntity;
import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardImgRepository extends JpaRepository<BoardImgEntity, String> {
}
