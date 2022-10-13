package chitchat.Service;

import chitchat.Model.Post;
import chitchat.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostService {
    PostRepository postRepository;

    @Autowired
    public PostService (PostRepository postRepository){this.postRepository = postRepository;}

    //ALL POSTS
    public List<Post> getAllPosts(){return postRepository.findAll();}

    //POST BY POSTID
    public Post getPostById(int postId) {return postRepository.findById(postId).get();
    }

    //ADD NEW POST
    public Post addPost(Post post) {return postRepository.save(post);}

    //

}
