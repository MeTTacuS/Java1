package lt.vu.mybatis.model;

public class Owner {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.OWNER.ID
     *
     * @mbg.generated Mon May 18 19:33:19 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.OWNER.NAME
     *
     * @mbg.generated Mon May 18 19:33:19 EEST 2020
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.OWNER.ID
     *
     * @return the value of PUBLIC.OWNER.ID
     *
     * @mbg.generated Mon May 18 19:33:19 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.OWNER.ID
     *
     * @param id the value for PUBLIC.OWNER.ID
     *
     * @mbg.generated Mon May 18 19:33:19 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.OWNER.NAME
     *
     * @return the value of PUBLIC.OWNER.NAME
     *
     * @mbg.generated Mon May 18 19:33:19 EEST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.OWNER.NAME
     *
     * @param name the value for PUBLIC.OWNER.NAME
     *
     * @mbg.generated Mon May 18 19:33:19 EEST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", getClass().getSimpleName());
    }
}