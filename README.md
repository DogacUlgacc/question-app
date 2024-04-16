
QuestionApp is a Java Spring Boot application designed to foster user interaction through a question-and-answer forum. Users can actively participate by creating posts, engaging in discussions through comments, and searching for posts based on user or post ID. The application demonstrates the implementation of core CRUD (Create, Read, Update, Delete) operations for users, posts, and comments, utilizing Spring Data JPA for seamless data persistence.
The Java project offers a robust and customizable foundation for creating and managing user-generated content (UGC) within web applications, particularly those focused on social media or blogging.



Exploring the Project Structure:

Entities (com.dogac.questionapp.entities): This package houses the core building blocks of the application represented by Java classes:
User: Encapsulates user information like username and password.
Post: Represents a question or topic of discussion. It stores title, text, and references the user who created it.
Comment: Represents a response left on a post by a user. It contains text and references to the user who authored it and the associated post.
Repositories (com.dogac.questionapp.repo): Spring Data JPA repositories reside in this package, providing methods for interacting with the database for each entity:
UserRepository: Manages user data.
PostRepository: Manages post data.
CommentRepository: Manages comment data.
Request DTOs (com.dogac.questionapp.requests): This package defines Data Transfer Objects (DTOs) used for receiving data from the client:
PostCreateRequest: Captures information required to create a new post.
PostUpdateRequest: Captures information needed to update an existing post.
CommentCreateRequest: Holds information required for creating a new comment.
CommentUpdateRequest: Holds information for updating an existing comment.
Services (com.dogac.questionapp.service): This package encompasses service classes responsible for handling business logic and interacting with repositories:
UserService: Provides methods for user management tasks.
PostService: Provides methods for managing posts.
CommentService: Provides methods for managing comments.
