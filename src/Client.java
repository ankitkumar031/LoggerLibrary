public class Client {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.info("DISPLAYING INFO");
        logger.error("DISPLAYING ERROR");
        logger.debug("DISPLAYING DEBUG");
        logger.warning("DISPLAYING WARNING");
        logger.fatal("DISPLAYING FATAL");
    }
}
