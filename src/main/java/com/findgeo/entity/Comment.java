package com.findgeo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicInsert
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentid;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;
	
	@Column(nullable = false)
	private boolean deleted;
	
	@Column(nullable = false)
	private String content;
	
	@JoinColumn(name="boardid")
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Posts posts;
	
	@JoinColumn(name = "parent_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Comment parent;
	

	@OneToMany(mappedBy = "parent", orphanRemoval = true)
	private List<Comment> children = new ArrayList<>();
	//최상위 객체를 삭제하면 하위 객체들을 전부 삭제된다. 
	 
    public Comment(String content, Member member, Posts posts, Comment parent) {
        this.content = content;
        this.member = member;
        this.posts = posts;
        this.parent = parent;
        this.deleted = false;
    }
    
    public Optional<Comment> findDeletableComment() {
        return hasChildren() ? Optional.empty() : Optional.of(findDeletableCommentByParent());
    }

    public void delete() {
        this.deleted = true;
    }

    private Comment findDeletableCommentByParent() { // 1
        if (isDeletedParent()) {
            Comment deletableParent = getParent().findDeletableCommentByParent();
            if(getParent().getChildren().size() == 1) return deletableParent;
        }
        return this;
    }

    private boolean hasChildren() {
        return getChildren().size() != 0;
    }

    private boolean isDeletedParent() { // 2
        return getParent() != null && getParent().isDeleted();
    }
	public void update(String content) {
		this.content = content;
	}
	
	//부모 댓글 수정
	public void updateParent(Comment parent) {
		this.parent = parent;
	}

	public LocalDateTime getCreateDate() {
		return getCreateDate();
	}




	
	
}
