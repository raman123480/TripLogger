package com.example.student.triplogger;

/**
 * Created by faisalali on 10/31/2016.
 */
public class tripLoggerClass {

    private int id;
    private String name;
    private String title;
    private String destination;
    private String date;
    private String tripType;
    private String email;
    private String comment;
    private String duration;
    private String GPRSLocation;
    private String enrollment;
    private String gender;
    private byte[] img;


    public tripLoggerClass(){}

    public tripLoggerClass(String Title, String Date, String TripType, String Destination,
                           String Duration, String Comment, String GprsLocation, byte[] Img) {
        this.title = Title; this.date = Date; this.tripType = TripType;
        this.destination = Destination; this.duration = Duration; this.comment = Comment;
        this.GPRSLocation = GprsLocation; this.img = Img;
    }

    public tripLoggerClass(String title, String Date, String Destination){

        this.setId(id);
        this.setDate(date);
        this.setDuration(duration);
    }

    public tripLoggerClass(String Name, String Enrollment, String Email, String Gender, String Comment ){

        this.name = Name; this.enrollment = Enrollment; this.email = Email; this.gender = Gender;
        this.comment = Comment;
    }

    public int getId(){return id;}
    public void setId(int Id){this.id = Id;}

    public String getTitle(){return name;}
    public void setTitle(String Title){this.title = Title;}

    public String getDate(){return date;}
    public void setDate(String Date){this.date = Date;}

    public String getTripType(){return tripType;}
    public void setTripType(String TripType){this.tripType = TripType;}

    public String getDestination(){return destination;}
    public void setDestination(String Destination){this.destination = Destination;}

    public String getDuration(){return duration;}
    public void setDuration(String Duration){this.duration = duration;}

    public String getComment(){return comment;}
    public void setComment(String Comment){this.comment = Comment;}

    public String getGPRSLocation(){return GPRSLocation;}
    public void setGPRSLocation(String Gprslocation){this.GPRSLocation = Gprslocation;}

    public String getName(){return name;}
    public void setName(String Name){this.name = Name;}

    public String getEnrollment(){return enrollment;}
    public void setEnrollment(String Enrollment){this.enrollment = Enrollment;}

    public String getGender(){return name;}
    public void setGender(String Gender){this.gender = Gender;}

    }
