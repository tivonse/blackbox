import org.springframework.boot.SpringApplication

// In groovy every class is public by default
// so you don't need to write "public class" anymore
@SpringBootApplication
class Application {

    // Every method is public as well
    static void main(String[] args) {

        // You can omit the last method call parenthesis
        // This is the same as .run(Application, args)
        // also you can omit ;
        SpringApplication.run Application, args
    }
}