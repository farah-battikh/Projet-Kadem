package tn.esprit.springproject.entity;

public class StatistiquesFoyers {
    private Double averageCapacity;
    private Long maxCapacity;


    public StatistiquesFoyers(Double averageCapacity, Long maxCapacity) {
        this.averageCapacity = averageCapacity;
        this.maxCapacity = maxCapacity;
    }

    public Double getAverageCapacity() {
        return averageCapacity;
    }

    public void setAverageCapacity(Double averageCapacity) {
        this.averageCapacity = averageCapacity;
    }

    public Long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
