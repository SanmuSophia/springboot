package gcyl.entity.domain.model;

import java.io.Serializable;

public class QrCode implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_qr_code.id
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_qr_code.shop_id
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    private Long shopId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_qr_code.table_num
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    private Integer tableNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_qr_code.qr_code_img
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    private String qrCodeImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tyg_ms_qr_code.gmt_create
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    private Long gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tyg_ms_qr_code
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_qr_code.id
     *
     * @return the value of tyg_ms_qr_code.id
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_qr_code.id
     *
     * @param id the value for tyg_ms_qr_code.id
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_qr_code.shop_id
     *
     * @return the value of tyg_ms_qr_code.shop_id
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_qr_code.shop_id
     *
     * @param shopId the value for tyg_ms_qr_code.shop_id
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_qr_code.table_num
     *
     * @return the value of tyg_ms_qr_code.table_num
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public Integer getTableNum() {
        return tableNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_qr_code.table_num
     *
     * @param tableNum the value for tyg_ms_qr_code.table_num
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_qr_code.qr_code_img
     *
     * @return the value of tyg_ms_qr_code.qr_code_img
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public String getQrCodeImg() {
        return qrCodeImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_qr_code.qr_code_img
     *
     * @param qrCodeImg the value for tyg_ms_qr_code.qr_code_img
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public void setQrCodeImg(String qrCodeImg) {
        this.qrCodeImg = qrCodeImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tyg_ms_qr_code.gmt_create
     *
     * @return the value of tyg_ms_qr_code.gmt_create
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tyg_ms_qr_code.gmt_create
     *
     * @param gmtCreate the value for tyg_ms_qr_code.gmt_create
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tyg_ms_qr_code
     *
     * @mbggenerated Fri Jan 18 10:29:56 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", tableNum=").append(tableNum);
        sb.append(", qrCodeImg=").append(qrCodeImg);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}