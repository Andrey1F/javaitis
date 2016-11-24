package ru.itis.model;

public class Auto {
    private int id;
    private int ownerId;
    private String model;
    private int mileage;

    private Auto(int id, int ownerId, String model, int mileage) {
        this.id = id;
        this.ownerId = ownerId;
        this.model = model;
        this.mileage = mileage;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    public static class Builder {
        private int id;
        private int ownerId;
        private String model;
        private int mileage;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setOwnerId(int ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder setModel(String  model) {
            this.model = model;
            return this;
        }

        public Builder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Auto build() {
            return new Auto(this.id, this.ownerId, this.model, this.mileage);
        }
    }
}