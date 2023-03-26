package org.siit.homework.hw3Tema41;

    public abstract class Phone {
        private Contact contact1;
        private Contact contact2;
        private String callHistory = "";
        private int batteryLife;
        private String color;
        private String material;
        private final int imei;
        private static int imeiCounter = 1000;

        public void setColor(String color) {
            this.color = color;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public Phone(int batteryLife) {
            this.batteryLife = batteryLife;
            this.imei = imeiCounter++;
        }

        public Contact getFirstContact() {
            return contact1;
        }

        public Contact getLastContact() {
            return contact2;
        }

        void addContact(String index, String phoneNumber, String firstName, String lastName) {
            if (index.equals("1")) {
                contact1 = new Contact(phoneNumber, firstName, lastName);
            } else if (index.equals("2")) {
                contact2 = new Contact(phoneNumber, firstName, lastName);
            }
        }

        void sendMessage(String phoneNumber, String content) {
            if (content.length() > 500) {
                System.out.println("Message is too long.");
                return;
            }
            if (phoneNumber.equals(contact1.getPhoneNumber())) {
                if (contact1.getMessage1() == null) {
                    contact1.setMessage1(content);
                } else {
                    contact1.setMessage2(content);
                }
            } else if (phoneNumber.equals(contact2.getPhoneNumber())) {
                if (contact2.getMessage1() == null) {
                    contact2.setMessage1(content);
                } else {
                    contact2.setMessage2(content);
                }
            }
            batteryLife = batteryLife - 1;
        }
        String getFirstMessage(String phoneNumber) {
            if (phoneNumber.equals(contact1.getPhoneNumber())) {
                return contact1.getMessage1();
            } else if (phoneNumber.equals(contact2.getPhoneNumber())) {
                return contact2.getMessage1();
            }
            return null;
        }

        String getSecondMessage(String phoneNumber) {
            if (phoneNumber.equals(contact1.getPhoneNumber())) {
                return contact1.getMessage2();
            } else if (phoneNumber.equals(contact2.getPhoneNumber())) {
                return contact2.getMessage2();
            }
            return null;
        }

        void call(String phoneNumber) {
            callHistory = callHistory + phoneNumber + "\n";
            batteryLife = batteryLife - 2;
        }

        void viewHistory() {
            System.out.println("Phone history:");
            System.out.println(callHistory);
        }

        @Override
        public String toString() {
            return "{" +
                    "batteryLife =" + batteryLife +
                    ", color ='" + color + '\'' +
                    ", material ='" + material + '\'' +
                    ", imei =" + imei +
                    '}';
        }
}
