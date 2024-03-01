package Blog.usecases;

public interface Usecase<InputDto, OutputDto> {

	OutputDto execute(InputDto input);

}
