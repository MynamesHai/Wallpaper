package com.androidvn.wallpaper.data.model.wallpaper;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.androidvn.wallpaper.data.model.category.DaoSession;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(nameInDb = "WallpaperInfo")
public class WallpaperInfo {
    @Id(autoincrement = true)
    private long id;

    private long wallpaperInfoId;

    @ToOne(joinProperty = "wallpaperInfoId")
    private Wallpapers wallpapers;

    @Expose
    @SerializedName("alias_title")
    public String aliasTitle;

    @Expose
    @SerializedName("title")
    public String titleWallpaper;

    @Expose
    @SerializedName("author")
    public String authorWallpaper;

    @Expose
    @SerializedName("download_count")
    public String downloadCount;

    @Expose
    @SerializedName("thumbnail_url")
    public String thumbnailWallpaper;

    @Expose
    @SerializedName("image_path")
    public String imagePathWallpaper;

    @Expose
    @SerializedName("preview")
    public String previewWallpaper;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 569544554)
    private transient WallpaperInfoDao myDao;

    @Generated(hash = 2003052967)
    public WallpaperInfo(long id, long wallpaperInfoId, String aliasTitle,
            String titleWallpaper, String authorWallpaper, String downloadCount,
            String thumbnailWallpaper, String imagePathWallpaper,
            String previewWallpaper) {
        this.id = id;
        this.wallpaperInfoId = wallpaperInfoId;
        this.aliasTitle = aliasTitle;
        this.titleWallpaper = titleWallpaper;
        this.authorWallpaper = authorWallpaper;
        this.downloadCount = downloadCount;
        this.thumbnailWallpaper = thumbnailWallpaper;
        this.imagePathWallpaper = imagePathWallpaper;
        this.previewWallpaper = previewWallpaper;
    }

    @Generated(hash = 1124171062)
    public WallpaperInfo() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWallpaperInfoId() {
        return this.wallpaperInfoId;
    }

    public void setWallpaperInfoId(long wallpaperInfoId) {
        this.wallpaperInfoId = wallpaperInfoId;
    }

    public String getAliasTitle() {
        return this.aliasTitle;
    }

    public void setAliasTitle(String aliasTitle) {
        this.aliasTitle = aliasTitle;
    }

    public String getTitleWallpaper() {
        return this.titleWallpaper;
    }

    public void setTitleWallpaper(String titleWallpaper) {
        this.titleWallpaper = titleWallpaper;
    }

    public String getAuthorWallpaper() {
        return this.authorWallpaper;
    }

    public void setAuthorWallpaper(String authorWallpaper) {
        this.authorWallpaper = authorWallpaper;
    }

    public String getDownloadCount() {
        return this.downloadCount;
    }

    public void setDownloadCount(String downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getThumbnailWallpaper() {
        return this.thumbnailWallpaper;
    }

    public void setThumbnailWallpaper(String thumbnailWallpaper) {
        this.thumbnailWallpaper = thumbnailWallpaper;
    }

    public String getImagePathWallpaper() {
        return this.imagePathWallpaper;
    }

    public void setImagePathWallpaper(String imagePathWallpaper) {
        this.imagePathWallpaper = imagePathWallpaper;
    }

    public String getPreviewWallpaper() {
        return this.previewWallpaper;
    }

    public void setPreviewWallpaper(String previewWallpaper) {
        this.previewWallpaper = previewWallpaper;
    }

    @Generated(hash = 1327644552)
    private transient Long wallpapers__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1475129169)
    public Wallpapers getWallpapers() {
        long __key = this.wallpaperInfoId;
        if (wallpapers__resolvedKey == null
                || !wallpapers__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WallpapersDao targetDao = daoSession.getWallpapersDao();
            Wallpapers wallpapersNew = targetDao.load(__key);
            synchronized (this) {
                wallpapers = wallpapersNew;
                wallpapers__resolvedKey = __key;
            }
        }
        return wallpapers;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 513702371)
    public void setWallpapers(@NotNull Wallpapers wallpapers) {
        if (wallpapers == null) {
            throw new DaoException(
                    "To-one property 'wallpaperInfoId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.wallpapers = wallpapers;
            wallpaperInfoId = wallpapers.getId();
            wallpapers__resolvedKey = wallpaperInfoId;
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
    @Generated(hash = 120793401)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWallpaperInfoDao() : null;
    }

}
