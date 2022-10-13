package chitchat.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Entity
@CrossOrigin
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int postId;

    @Column
    public String postTitle;

    @Column
    public String postBody;

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    public List<Comment> comments;
}
