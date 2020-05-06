package cam.utils;

public interface Constant {
    // Data base
    String DRIVER_NAME = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/cam";
    String DB_USER_NAME = "root";
    String DB_PASS = "samtron";

    String USER_NAME = "admin";
    String PASSWORD = "admin";

    String USER_INSERT = "insert into users(name, password, email, address, city, contact) values(?,?,?,?,?,?)";
    String USER_DELETE = "delete from users where id=?";
    String USER_LOGIN_SELECT = "select * from users where name=? and password=?";
    String USER_SELECT = "select * from users";

    String ROOM_INSERT = "insert into room(room_id, name, capacity, room_type, available_from, available_to, available_for, is_available) values(?,?,?,?,?,?,?,?)";
    String ROOM_SELECT_ACTIVE = "select room_id from room where is_available=?";
    String BOOKING_INSERT = "insert into booking(room_id, booked_by, guest_id, guest_address, guest_contact, booked_for, booked_from, booked_to, reason) values(?,?,?,?,?,?,?,?,?)";
    String BOOKING_DELETE = "delete from booking where booking_id=?";

    String ROOM_SELECT = "select * from room ";
    String ROOM_PAST_SELECT = "select * from booking where booked_to <= now()";
    String ROOM_CURRENT_SELECT = "select * from booking where booked_to >= now()";
    // FONT
    String FONT = "Helvetica";
    // Lables
    String TITLE = "College Real Estate Management";
    String MANAGER_LOGIN = "Manager Login";
    String MANAGER_SECTION = "Manager Section";
    String ADD_CLERK = "Add Clerk";
    String VIEW_CLERK = "View Clerks";
    String DELETE_CLERK = "Delete Clerk";
    String CLERK_LOGIN = "Clerk Login";
    String LOGIN = "Login";
    String LOGOUT = "Logout";
    String BACK = "Back";
    String DELETE = "Delete";
    String ADD_ROOM = "Add Room";
    String VIEW_ALL_ROOMS = "View All Rooms";
    String BOOK_ROME = "Book Room";
    String VIEW_BOOKINGS = "View Bookings";
    String VIEW_HISTORY_BOOKINGS= "View History Bookings";
    String CANCEL_BOOKINGS= "Cancel Bookings";
    String ENTER_NAME = "Enter Name:";
    String ENTER_PASS = "Enter Password:";
    String ENTER_ID = "Enter Id:";
    String NAME = "Name:";
    String PASS = "Password:";
    String EMAIL = "Email:";
    String ADDRESS = "Address:";
    String CITY = "City:";
    String CONTACT_NO = "Contact No:";
    String ROOM_NO = "Room No:";
    String CAPACITY = "Capacity:";
    String ROOM_TYPE = "Room Type:";
    String AVAILABLE_START_DATE = "Available Start Date:";
    String AVAILABLE_END_DATE= "Available End Date:";
    String AVAILABLE_FOR = "Available For:";
    String IS_AVAILABLE = "Is Available:";
    String CANCEL_BOOKING = "Cancel Booking";
    String BOOKING_ID = "Booking Id:";
    String BOOKED_BY = "Booked By:";
    String BOOKED_GUEST_ID = "Booked Guest Id:";
    String BOOKED_GUEST_ADDRESS = "Booked Guest Address:";
    String BOOKED_GUEST_CONTACT = "Booked Guest Contact :";
    String BOOKED_FOR = "Booked For:";
    String FROM = "From:";
    String TO = "To:";
    String REASON = "Reason:";
    // Alert Msg
    String LOGIN_INVALID = "Sorry, Username or Password Error";
    String ID_NOT_NULL = "Id can't be blank";
    String CLERK_DELETE_SUCCESS = "Clerk deleted successfully!";
    String UNABLE_TO_DELETE = "Unable to delete given id!";
    String CLERK_SUCCESS = "Clerk added successfully!";
    String UNABLE_SAVE = "Sorry, unable to save!";
    String ROOM_ADDED = "Rooms added successfully!";
    String BOOKING_CANCEL_SUCCESS = "Booking Canceled successfully!";
    String SORRY_UNABLE_TO_CANCEL = "Sorry, unable to Cancel booking!";
    // Alert TITLE
    String LOGIN_ERROR = "Login Error!";
    String UNABLE_RO_BOOK_ROOM = "Sorry, unable to Book Room!" ;
    String ROOM_SUCCESS = "Room Booked successfully!";

    // NOTE
    String BEFORE_CANCEL = "Note: Please check before canceling booking!";
    String CHECK_GUEST = "Note: Check Guest id Carefully before booking Room!!";


    String PLS_ADD_ROOMS= "Please add Rooms!";

}
