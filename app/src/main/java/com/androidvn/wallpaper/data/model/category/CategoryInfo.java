package com.androidvn.wallpaper.data.model.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;


@Entity(nameInDb = "CategoryInfo")
public class CategoryInfo {
    @Id(autoincrement = true)
    public Long id;

    private long categoriesID;

    @ToOne(joinProperty = "categoriesID")
    public Categories categories;

    @Expose
    @SerializedName("category_id")
    public long categoryId;

    @Expose
    @SerializedName("category_name")
    public String categoryName;

    @Expose
    @SerializedName("thumbnail")
    public String categoryThumbnail;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1943374341)
    private transient CategoryInfoDao myDao;

    @Generated(hash = 1762046266)
    public CategoryInfo(Long id, long categoriesID, long categoryId,
            String categoryName, String categoryThumbnail) {
        this.id = id;
        this.categoriesID = categoriesID;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryThumbnail = categoryThumbnail;
    }

    @Generated(hash = 576313791)
    public CategoryInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCategoriesID() {
        return this.categoriesID;
    }

    public void setCategoriesID(long categoriesID) {
        this.categoriesID = categoriesID;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryThumbnail() {
        return this.categoryThumbnail;
    }

    public void setCategoryThumbnail(String categoryThumbnail) {
        this.categoryThumbnail = categoryThumbnail;
    }

    @Generated(hash = 939124549)
    private transient Long categories__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 436350759)
    public Categories getCategories() {
        long __key = this.categoriesID;
        if (categories__resolvedKey == null
                || !categories__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoriesDao targetDao = daoSession.getCategoriesDao();
            Categories categoriesNew = targetDao.load(__key);
            synchronized (this) {
                categories = categoriesNew;
                categories__resolvedKey = __key;
            }
        }
        return categories;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 987340816)
    public void setCategories(@NotNull Categories categories) {
        if (categories == null) {
            throw new DaoException(
                    "To-one property 'categoriesID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.categories = categories;
            categoriesID = categories.getId();
            categories__resolvedKey = categoriesID;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 139594180)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCategoryInfoDao() : null;
    }



}
