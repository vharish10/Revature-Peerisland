    class InvalidCustomerNameException extends Exception {
        public InvalidCustomerNameException(String message) {
            super(message);
        }
    }

    class InvalidMovieException extends Exception {
        public InvalidMovieException(String message) {
            super(message);
        }
    }

    class InvalidTicketCountException extends Exception {
        public InvalidTicketCountException(String message) {
            super(message);
        }
    }

    class InsufficientSeatsException extends Exception {
        public InsufficientSeatsException(String message) {
            super(message);
        }
    }

    class PaymentFailedException extends Exception {
        public PaymentFailedException(String message) {
            super(message);
        }
    }

    class CancellationNotAllowedException extends Exception {
        public CancellationNotAllowedException(String message) {
            super(message);
        }
    }
