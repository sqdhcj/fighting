package com.hdd.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 角色实体
 */
@Entity
@Table(name="sysrole")
public class SysRole
{
    @Id
    @GeneratedValue(generator = "myuuid")
    @GenericGenerator(name="myuuid",strategy = "uuid")
    @Column(length = 32)
    private String uuid;

    @Column(length=30)
    private  String rolename;

    @Column(length=200)
    private  String roledesc;

    /*
    级联刷新，当A实体中有B实体这个属性，数据库操作，更新A时，会先刷新B，再将A和B保存；
     */
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysAuth> sysAuths;

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getRolename(){return rolename;}

    public void setRolename(String rolename){this.rolename = rolename;}

    public String getRoledesc(){return roledesc;}

    public void setRoledesc(String roledesc){this.roledesc = roledesc;}

    public List<SysAuth> getSysAuths()
    {
        return sysAuths;
    }

    public void setSysAuths(List<SysAuth> sysAuths)
    {
        this.sysAuths = sysAuths;
    }
}