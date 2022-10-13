package chitchat.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Entity
@CrossOrigin
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int commentId;

    @Column
    public String commentBody;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "post_id")
    public Post post;
}
