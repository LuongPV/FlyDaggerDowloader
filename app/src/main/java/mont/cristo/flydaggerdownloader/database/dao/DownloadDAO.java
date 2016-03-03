package mont.cristo.flydaggerdownloader.database.dao;

import java.util.List;

import mont.cristo.flydaggerdownloader.helpers.network.DownloadInfo;

public interface DownloadDAO {

    /**
     * Insert download record by list
     *
     * @param listDownloadInfo List need to add
     * @return Total record inserted successfully
     */
    int insertDownloadInfoList(List<DownloadInfo> listDownloadInfo);

    /**
     * Insert download record
     *
     * @param downloadInfo DownloadInfo object need to add
     * @return Is record added successfully
     */
    boolean insertDownloadInfo(DownloadInfo downloadInfo);

    List<DownloadInfo> getAllDownloadInfo();
}
