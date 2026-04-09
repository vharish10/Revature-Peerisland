package RevConnect;

import RevConnect.model.*;
import RevConnect.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc =new Scanner(System.in);

    static UserService userService = new UserService();
    static PostService postService = new PostService();
    static LikeService likeService = new LikeService();
    static CommentService commentService = new CommentService();
    static FollowService followService = new FollowService();
    static ConnectionService connectionService = new ConnectionService();
    static FeedService feedService = new FeedService();

    static User currentUser = null;

    public static void register() {
        try {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            User user = new User(name, username, email, password,
                    "Unknown", true, LocalDate.now(), "PERSONAL");

            String result = userService.register(user);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login() {
        try {
            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            currentUser = userService.login(email, password);

            if (currentUser != null) {
                System.out.println("Login successful!");
                userMenu();
            } else {
                System.out.println("Invalid credentials");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userMenu() {

        while (true) {
            System.out.println("Choose your choice");
            System.out.println("1. Create Post");
            System.out.println("2. View Feed");
            System.out.println("3. Like Post");
            System.out.println("4. Comment");
            System.out.println("5. Follow User");
            System.out.println("6. Send Connection");
            System.out.println("7. Logout");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createPost();
                case 2 -> viewFeed();
                case 3 -> likePost();
                case 4 -> commentPost();
                case 5 -> followUser();
                case 6 -> sendConnection();
                case 7 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void createPost() {
        try {
            System.out.print("Enter content: ");
            String content = sc.nextLine();
            Post post = new Post(currentUser.getUserId(), content);
            String result = postService.createPost(post, currentUser.getUserType());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewFeed() {
        try {
            List<Post> feed = feedService.getFeed(currentUser.getUserId());
            if (feed.isEmpty()) {
                System.out.println("No posts available");
            } else {
                for (Post p : feed) {
                    System.out.println("\nPost ID: " + p.getPostId());
                    System.out.println("Content: " + p.getContent());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void likePost() {
        try {
            System.out.print("Post ID: ");
            int postId = sc.nextInt();

            String result = likeService.likePost(currentUser.getUserId(), postId);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void commentPost() {
        try {
            System.out.print("Post ID: ");
            int postId = sc.nextInt();
            sc.nextLine();

            System.out.print("Comment: ");
            String text = sc.nextLine();

            Comment comment = new Comment(currentUser.getUserId(), postId, text);

            String result = commentService.addComment(comment);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void followUser() {
        try {
            System.out.print("User ID to follow: ");
            int id = sc.nextInt();

            String result = followService.follow(currentUser.getUserId(), id);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sendConnection() {
        try {
            System.out.print("User ID: ");
            int id = sc.nextInt();

            String result = connectionService.sendRequest(currentUser.getUserId(), id);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println(" RevConnect ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

}