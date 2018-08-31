package com.androidvn.wallpaper.data.model.wallpaper;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.androidvn.wallpaper.data.model.category.DaoSession;

@Entity(nameInDb = "Wallpapers")
public class Wallpapers {
    @Id(autoincrement = true)
    private Long id;

    @SerializedName("stime")
    public long createdTime;

    @ToMany(referencedJoinProperty = "wallpaperInfoId")
    @SerializedName("data")
    public List<WallpaperInfo> listWallpaper;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1990793018)
    private transient WallpapersDao myDao;

    @Generated(hash = 1006794627)
    public Wallpapers(Long id, long createdTime) {
        this.id = id;
        this.createdTime = createdTime;
    }

    @Generated(hash = 1204855332)
    public Wallpapers() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 765325599)
    public List<WallpaperInfo> getListWallpaper() {
        if (listWallpaper == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WallpaperInfoDao targetDao = daoSession.getWallpaperInfoDao();
            List<WallpaperInfo> listWallpaperNew = targetDao
                    ._queryWallpapers_ListWallpaper(id);
            synchronized (this) {
                if (listWallpaper == null) {
                    listWallpaper = listWallpaperNew;
                }
            }
        }
        return listWallpaper;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 613386142)
    public synchronized void resetListWallpaper() {
        listWallpaper = null;
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
    @Generated(hash = 755149636)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWallpapersDao() : null;
    }


}
