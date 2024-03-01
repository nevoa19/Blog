package Blog.usecases.post.find;

import Blog.domain.post.gateway.PostGateway;
import Blog.usecases.Usecase;
import Blog.usecases.exceptions.NotfoundException;

public class FindPostUsecase implements Usecase<FindPostInputDto, FindPostOutputDto> {
    private PostGateway postGateway;
    
    private FindPostUsecase(PostGateway postGateway) {
    	this.postGateway = postGateway;
    }
    
    public static FindPostUsecase create(final PostGateway aGateway) {
    	return new FindPostUsecase(aGateway);
    }
	
	@Override
	public FindPostOutputDto execute(FindPostInputDto input) {
		var aPost = postGateway.find(input.id());
		 if(aPost == null) {
	            throw new NotfoundException("post not found");
	        }
		 return new FindPostOutputDto(aPost.getId(),aPost.getTitle(),aPost.getContent(),aPost.getAuthor(),aPost.getDate());
	}

}
