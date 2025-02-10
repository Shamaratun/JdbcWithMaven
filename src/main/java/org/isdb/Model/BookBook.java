package org.isdb.Model;

public class BookBook {

        private int id;
        private String title;
        private String author;
        private double price;
        private boolean available;

        public BookBook() {
        }


        public BookBook(int id, String title, String author, double price, boolean available) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.price = price;
            this.available = available;
        }

        public BookBook(String title, String author, double price, boolean available) {
            this.title = title;
            this.author = author;
            this.price = price;
            this.available = available;

        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }




