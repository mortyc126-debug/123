package rd;

import ak0.q;
import com.gnacba.amuvvoafs.gms.internal.ads.ds0;
import f3.f2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.core.app.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends ds0 {
    public final /* synthetic */ int c = 1;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(m mVar, int i) {
        super(i, 2);
        this.d = mVar;
    }

    public final void h(tlydtdl.sqlite.db.framework.c cVar) {
        switch (this.c) {
            case 0:
                g gVar = new g(cVar);
                qd.f.p(gVar, (Integer) null, "CREATE TABLE AppDb (\n    appVersion INTEGER\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE Bands (\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    band TEXT NOT NULL,\n    isMember INTEGER NOT NULL,\n    picture TEXT NOT NULL,\n    name TEXT NOT NULL,\n    status TEXT,\n    username TEXT NOT NULL,\n    membersCount INTEGER NOT NULL,\n    role TEXT\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE ChatMediaAttachments(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    messageId TEXT NOT NULL,\n    type TEXT NOT NULL,\n    contentType TEXT NOT NULL,\n    caption TEXT,\n    file TEXT NOT NULL,\n    uploadStatus TEXT NOT NULL,\n    metaData TEXT,\n    CONSTRAINT fk_chat_messages\n        FOREIGN KEY (messageId)\n        REFERENCES ChatMessagesQueue(id)\n        ON DELETE CASCADE\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE ChatMessagesQueue(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    createdOn INTEGER NOT NULL,\n    message TEXT NOT NULL,\n    status TEXT NOT NULL,\n    conversationId TEXT NOT NULL,\n    animation TEXT,\n    links TEXT,\n    errorText TEXT,\n    replyMessage TEXT\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE MixEditorStates (\n    revisionStamp TEXT PRIMARY KEY UNIQUE ON CONFLICT REPLACE,\n    -- `state` is legacy and is superceded by `stateFile`, whose adapter is implemented\n    -- to actually store MixEditorState to a file on disk:\n    state TEXT,\n    updateDate TEXT,\n    stateFile TEXT\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE MixEditorUiStates (\n    revisionStamp TEXT PRIMARY KEY UNIQUE ON CONFLICT REPLACE,\n    uiState TEXT,\n    updateDate INTEGER\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE OtpPurchases(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    metadata TEXT NOT NULL,\n    paymentStatus TEXT NOT NULL,\n    orderId TEXT,\n    productId TEXT,\n    purchaseToken TEXT\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE my_revisions_v3 (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    created_on TEXT,\n    revision_id TEXT,\n    song_id TEXT,\n    sync_version INTEGER NOT NULL DEFAULT 0\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE RevisionSample (\n    sampleId TEXT NOT NULL,\n    revisionStamp TEXT NOT NULL,\n    UNIQUE(sampleId, revisionStamp) ON CONFLICT IGNORE,\n    FOREIGN KEY(sampleId) REFERENCES SyncSample(sampleId)\n        ON UPDATE RESTRICT\n        ON DELETE CASCADE,\n    FOREIGN KEY(revisionStamp) REFERENCES SyncRevision(revisionStamp)\n        ON UPDATE RESTRICT\n        ON DELETE CASCADE\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE Settings (\n    userId TEXT NOT NULL,\n    key TEXT NOT NULL,\n    setting TEXT NOT NULL,\n    fileSettings TEXT DEFAULT NULL,\n    PRIMARY KEY (userId, key) ON CONFLICT REPLACE\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE Songs (\n    -- Together with songId/songStamp makes unique pairs that helps us to distinguish songs of different users\n    -- NOTE: it is not the same as authorId (tho it can be equal for private/non-band songs)\n    userId TEXT NOT NULL,\n    songId TEXT,\n    songStamp TEXT,\n\n    song TEXT NOT NULL,\n    songName TEXT NOT NULL,\n\n    isCollaborator INTEGER NOT NULL,\n    isPublic INTEGER NOT NULL,\n    isFork INTEGER NOT NULL,\n\n    canEdit INTEGER NOT NULL,\n    canDelete INTEGER NOT NULL,\n\n    picture TEXT NOT NULL,\n    collaboratorsCount INTEGER NOT NULL,\n\n    lastRevisionCreatedOn TEXT NOT NULL,\n    createdOn TEXT NOT NULL,\n\n    authorId TEXT,\n    authorType TEXT,\n    authorName TEXT,\n\n    revisionId TEXT,\n    revisionStamp TEXT,\n\n    status TEXT,\n\n    CONSTRAINT PK_Songs PRIMARY KEY(userId, songId) ON CONFLICT REPLACE,\n    UNIQUE(userId, songStamp) ON CONFLICT REPLACE,\n    CHECK (songId IS NOT NULL OR songStamp IS NOT NULL),\n    CHECK (revisionStamp IS NOT NULL OR revisionId IS NOT NULL)\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS SyncHealthStats(\n    revisionStamp TEXT NOT NULL,\n    type TEXT NOT NULL,\n    success INTEGER NOT NULL,\n\n    FOREIGN KEY(revisionStamp) REFERENCES SyncRevision(revisionStamp)\n            ON UPDATE RESTRICT\n            ON DELETE CASCADE\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE SyncRevision (\n    userId TEXT NOT NULL,\n    revisionStamp TEXT UNIQUE ON CONFLICT FAIL NOT NULL,\n    revisionId TEXT,\n    -- Song stamp can be null on actual song, but we use songId if stamp is not there\n    songStamp TEXT NOT NULL,\n    songId TEXT,\n    -- ParentStamp and ParentId are nullable, it can be no parentStamp even when revision is synced (created on web for exampl\n    parentStamp TEXT,\n    parentId TEXT,\n    revision TEXT NOT NULL,\n    -- Fail message of lates sync, probably we should remove this field, replace with Status and move fail message to logs\n    failMessage TEXT,\n    createdOn TEXT NOT NULL,\n    -- Indicate where is the revision created from\n    source TEXT,\n    -- Indicate how revision was created\n    triggeredFrom TEXT,\n    -- Indicate tool name which was an initiator of the project\n    origin TEXT,\n    -- Metadata for revision save\n    metadata TEXT,\n    -- song stamp and song id are both nullable, we don't add fake stamp, only real one, generated locally and sent to server\n    CHECK (songStamp IS NOT NULL OR songId IS NOT NULL),\n    FOREIGN KEY(songStamp) REFERENCES SyncSong(songStamp)\n        ON UPDATE RESTRICT\n        ON DELETE CASCADE\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE SyncSample (\n    sampleId TEXT UNIQUE ON CONFLICT IGNORE NOT NULL,\n    type TEXT NOT NULL,\n    status TEXT NOT NULL,\n    availableLocally TEXT,\n    uploadStamp TEXT,\n    failMessage TEXT\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE SyncSong (\n    -- Actual song stamp (from song object) can be null, but we will use songId instead\n    songStamp TEXT UNIQUE ON CONFLICT REPLACE NOT NULL,\n    songId TEXT,\n    songName TEXT,\n    authorId TEXT NOT NULL,\n    authorType TEXT NOT NULL,\n    createdOn TEXT NOT NULL,\n    lastRevisionCreatedOn TEXT NOT NULL,\n    status TEXT\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE SyncSongCover (\n    songStamp TEXT UNIQUE ON CONFLICT REPLACE NOT NULL,\n    -- URL of remote cover file. doesn't include size prefix, so used to create Picture object\n    coverUrl TEXT,\n    -- File name of local path, doesn't include file path, only file name\n    coverFile TEXT,\n    failMessage TEXT,\n    CHECK (coverUrl IS NOT NULL OR coverFile IS NOT NULL),\n    FOREIGN KEY(songStamp) REFERENCES SyncSong(songStamp)\n            ON UPDATE RESTRICT\n            ON DELETE CASCADE\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE Tracks (\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    post TEXT NOT NULL,\n    picture TEXT NOT NULL,\n    userId TEXT NOT NULL,\n    state TEXT NOT NULL,\n    plays INTEGER NOT NULL,\n    createdOn TEXT NOT NULL\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE TracksUpload(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    albumId TEXT NOT NULL,\n    genreId TEXT,\n    displayName TEXT NOT NULL\n)");
                qd.f.p(gVar, (Integer) null, "CREATE TABLE VideoUploadFailures(\n    videoPath TEXT NOT NULL,\n    sessionId TEXT NOT NULL\n)");
                qd.f.p(gVar, (Integer) null, "CREATE VIEW SongWithRevision\nAS\nSELECT Songs.*, r.object AS revision FROM Songs\nLEFT JOIN my_revisions_v3 AS r ON revisionId = r.revision_id OR revisionStamp = r.object_id\nGROUP BY userId, songId, songStamp");
                qd.f.p(gVar, (Integer) null, "CREATE VIEW Projects\nAS\nSELECT\n    userId,\n    songId, songStamp, songName,\n    isCollaborator, isPublic, isFork,\n    canEdit, canDelete,\n    picture, collaboratorsCount,\n    lastRevisionCreatedOn, createdOn,\n    authorId, authorType, authorName,\n    revisionId, revisionStamp,\n    status\nFROM Songs");
                qd.f.p(gVar, (Integer) null, "CREATE VIEW RevisionSamples\nAS\nSELECT SyncSample.*, RevisionSample.revisionStamp FROM SyncSample\nLEFT JOIN RevisionSample ON SyncSample.sampleId = RevisionSample.sampleId");
                qd.e.a.getClass();
                break;
            default:
                ((m) this.d).e(new yb.a(cVar));
                break;
        }
    }

    public void i(tlydtdl.sqlite.db.framework.c cVar, int i, int i2) {
        switch (this.c) {
            case 1:
                k(cVar, i, i2);
                break;
            default:
                super.i(cVar, i, i2);
                break;
        }
    }

    public void j(tlydtdl.sqlite.db.framework.c cVar) {
        switch (this.c) {
            case 1:
                m mVar = (m) this.d;
                mVar.g(new yb.a(cVar));
                mVar.g = cVar;
                break;
        }
    }

    public final void k(tlydtdl.sqlite.db.framework.c cVar, int i, int i2) {
        switch (this.c) {
            case 0:
                g gVar = new g(cVar);
                long j2 = i;
                long j3 = i2;
                qd.a[] aVarArr = (qd.a[]) Arrays.copyOf((qd.a[]) this.d, 0);
                o.h(aVarArr, "callbacks");
                ArrayList arrayList = new ArrayList();
                if (aVarArr.length > 0) {
                    qd.a aVar = aVarArr[0];
                    throw null;
                }
                Iterator it = mx1.o.e1(arrayList, new q(27)).iterator();
                if (it.hasNext()) {
                    f2.y(it.next());
                    throw null;
                }
                if (j2 < j3) {
                    if (j2 <= 63 && j3 > 63) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS bands_v3 (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    is_member INTEGER,\n    name TEXT,\n    status TEXT,\n    username TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS my_songs_v6 (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    author_id TEXT,\n    author_type TEXT,\n    collaborators_count INTEGER,\n    is_collaborator INTEGER,\n    is_public INTEGER,\n    revision_created_on TEXT,\n    revision_id TEXT,\n    song_id TEXT,\n    song_name TEXT,\n    status TEXT\n)");
                    }
                    if (j2 <= 65 && j3 > 65) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS midiroll_state_table (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE\n)");
                    }
                    if (j2 <= 67 && j3 > 67) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS bands_v3 (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    is_member INTEGER,\n    name TEXT,\n    status TEXT,\n    username TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS my_songs_v6 (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    author_id TEXT,\n    author_type TEXT,\n    collaborators_count INTEGER,\n    is_collaborator INTEGER,\n    is_public INTEGER,\n    revision_created_on TEXT,\n    revision_id TEXT,\n    song_id TEXT,\n    song_name TEXT,\n    status TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS midiroll_state_table (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS sync_model (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    action TEXT,\n    class TEXT,\n    error_code TEXT,\n    error_msg TEXT,\n    msg TEXT,\n    params TEXT,\n    request_id TEXT,\n    wait_list TEXT,\n    UNIQUE (class, request_id) ON CONFLICT REPLACE\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS mix_editor_states (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    editing_finished INTEGER,\n    parent_revision_id TEXT,\n    update_date INTEGER\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS my_revisions_v3 (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    object TEXT,\n    object_id TEXT UNIQUE ON CONFLICT REPLACE,\n    created_on TEXT,\n    revision_id TEXT,\n    song_id TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS revision_processing (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    revision_id TEXT UNIQUE ON CONFLICT REPLACE,\n    revision_stage TEXT,\n    revision_state TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS sample_usage_count (\n    Id INTEGER PRIMARY KEY AUTOINCREMENT,\n    sample_ref_count INTEGER,\n    sample_id TEXT UNIQUE ON CONFLICT REPLACE,\n    sample_is_midi INTEGER,\n    sample_upload_stamp TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS bands_v2");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS my_profile_v2");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS my_songs_v2");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS my_songs_v3");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS my_songs_v4");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS my_songs_v5");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_mix_editor_states_object_id");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_my_revisions_v3_object_id");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_revision_processing_revision_id");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_sample_usage_count_sample_id");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS service_revision_table");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_bands_v3_object_id");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_my_songs_v6_object_id");
                        qd.f.p(gVar, (Integer) null, "DROP INDEX IF EXISTS index_midiroll_state_table_object_id");
                    }
                    if (j2 <= 68 && j3 > 68) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE my_revisions_v3 ADD COLUMN sync_version INTEGER NOT NULL DEFAULT 0");
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE my_songs_v6 ADD COLUMN userId TEXT");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS revision_processing");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS sample_usage_count");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS sync_model");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS AppDb (\n    appVersion INTEGER\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS SyncSample (\n    sampleId TEXT UNIQUE ON CONFLICT IGNORE NOT NULL,\n    type TEXT NOT NULL,\n    status TEXT NOT NULL,\n    availableLocally TEXT,\n    uploadStamp TEXT,\n    failMessage TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE SyncSong (\n    songStamp TEXT UNIQUE ON CONFLICT REPLACE NOT NULL,\n    songId TEXT,\n    songName TEXT,\n    authorId TEXT NOT NULL,\n    authorType TEXT NOT NULL,\n    createdOn TEXT NOT NULL,\n    lastRevisionCreatedOn TEXT NOT NULL,\n    status TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE SyncSongCover (\n    songStamp TEXT UNIQUE ON CONFLICT REPLACE NOT NULL,\n    -- URL of remote cover file (doesn't include size prefix\n    coverUrl TEXT,\n    -- File name of local path, doesn't include file path, only file name\n    coverFile TEXT,\n    failMessage TEXT,\n    CHECK (coverUrl IS NOT NULL OR coverFile IS NOT NULL),\n    FOREIGN KEY(songStamp) REFERENCES SyncSong(songStamp)\n            ON UPDATE RESTRICT\n            ON DELETE CASCADE\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS SyncRevision (\n    userId TEXT NOT NULL,\n    revisionStamp TEXT UNIQUE ON CONFLICT REPLACE NOT NULL,\n    revisionId TEXT,\n    songStamp TEXT NOT NULL,\n    songId TEXT,\n    parentStamp TEXT,\n    parentId TEXT,\n    revision TEXT NOT NULL,\n    failMessage TEXT,\n    createdOn TEXT NOT NULL,\n    CHECK (songStamp IS NOT NULL OR songId IS NOT NULL),\n    FOREIGN KEY(songStamp) REFERENCES SyncSong(songStamp)\n        ON UPDATE RESTRICT\n        ON DELETE CASCADE\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS SyncSongCover (\n    songStamp TEXT UNIQUE ON CONFLICT REPLACE NOT NULL,\n    coverUrl TEXT,\n    coverFileName TEXT,\n    failMessage TEXT,\n    FOREIGN KEY(songStamp) REFERENCES SyncSong(songStamp)\n            ON UPDATE RESTRICT\n            ON DELETE CASCADE\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS RevisionSample (\n    sampleId TEXT NOT NULL,\n    revisionStamp TEXT NOT NULL,\n    UNIQUE(sampleId, revisionStamp) ON CONFLICT IGNORE,\n    FOREIGN KEY(sampleId) REFERENCES SyncSample(sampleId)\n        ON UPDATE RESTRICT\n        ON DELETE CASCADE,\n    FOREIGN KEY(revisionStamp) REFERENCES SyncRevision(revisionStamp)\n        ON UPDATE RESTRICT\n        ON DELETE CASCADE\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE VIEW RevisionSamples\nAS\nSELECT SyncSample.*, RevisionSample.revisionStamp FROM SyncSample\nLEFT JOIN RevisionSample ON SyncSample.sampleId = RevisionSample.sampleId");
                    }
                    if (j2 <= 69 && j3 > 69) {
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS my_songs_v6");
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS bands_v3");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS Songs (\n    userId TEXT NOT NULL,\n    songId TEXT,\n    songStamp TEXT,\n\n    song TEXT NOT NULL,\n    songName TEXT NOT NULL,\n\n    isCollaborator INTEGER NOT NULL,\n    isPublic INTEGER NOT NULL,\n    isFork INTEGER NOT NULL,\n\n    canEdit INTEGER NOT NULL,\n    canDelete INTEGER NOT NULL,\n\n    picture TEXT NOT NULL,\n    collaboratorsCount INTEGER NOT NULL,\n\n    lastRevisionCreatedOn TEXT NOT NULL,\n    createdOn TEXT NOT NULL,\n\n    authorId TEXT,\n    authorType TEXT,\n    authorName TEXT,\n\n    revisionId TEXT,\n    revisionStamp TEXT,\n\n    status TEXT,\n\n    CONSTRAINT PK_Songs PRIMARY KEY(userId, songId) ON CONFLICT REPLACE,\n    UNIQUE(userId, songStamp) ON CONFLICT REPLACE,\n    CHECK (songId IS NOT NULL OR songStamp IS NOT NULL),\n    CHECK (revisionStamp IS NOT NULL OR revisionId IS NOT NULL)\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE VIEW IF NOT EXISTS SongWithRevision\nAS\nSELECT Songs.*, r.object AS revision FROM Songs\nLEFT JOIN my_revisions_v3 AS r ON revisionId = r.revision_id OR revisionStamp = r.object_id\nGROUP BY userId, songId, songStamp");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS Bands (\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    band TEXT NOT NULL,\n    isMember INTEGER NOT NULL,\n    picture TEXT NOT NULL,\n    name TEXT NOT NULL,\n    status TEXT,\n    username TEXT NOT NULL,\n    membersCount INTEGER NOT NULL,\n    role TEXT\n)");
                    }
                    if (j2 <= 70 && j3 > 70) {
                        qd.f.p(gVar, (Integer) null, "CREATE VIEW IF NOT EXISTS Projects\nAS\nSELECT\n    userId,\n    songId, songStamp, songName,\n    isCollaborator, isPublic, isFork,\n    canEdit, canDelete,\n    picture, collaboratorsCount,\n    lastRevisionCreatedOn, createdOn,\n    authorId, authorType, authorName,\n    revisionId, revisionStamp,\n    status\nFROM Songs");
                    }
                    if (j2 <= 71 && j3 > 71) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE SyncRevision ADD COLUMN source TEXT");
                    }
                    if (j2 <= 72 && j3 > 72) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS VideoUploadFailures(\n    videoPath TEXT NOT NULL,\n    sessionId TEXT NOT NULL\n)");
                    }
                    if (j2 <= 73 && j3 > 73) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS TracksUpload(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    albumId TEXT NOT NULL,\n    genreId TEXT,\n    displayName TEXT NOT NULL\n)");
                    }
                    if (j2 <= 74 && j3 > 74) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS SyncHealthStats(\n    revisionStamp TEXT NOT NULL,\n    type TEXT NOT NULL,\n    -- This migration was incorrect, but the data in DB is correct.\n    success INTEGER NOT NULL,\n\n    FOREIGN KEY(revisionStamp) REFERENCES SyncRevision(revisionStamp)\n            ON UPDATE RESTRICT\n            ON DELETE CASCADE\n)");
                    }
                    if (j2 <= 75 && j3 > 75) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE mix_editor_states ADD COLUMN revision_stamp TEXT");
                    }
                    if (j2 <= 76 && j3 > 76) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS ChatMessagesQueue(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    createdOn INTEGER NOT NULL,\n    message TEXT NOT NULL,\n    status TEXT NOT NULL,\n    conversationId TEXT NOT NULL,\n    animation TEXT,\n    links TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS ChatMediaAttachments(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    messageId TEXT NOT NULL,\n    type TEXT NOT NULL,\n    contentType TEXT NOT NULL,\n    caption TEXT,\n    file TEXT NOT NULL,\n    uploadStatus TEXT NOT NULL,\n    metaData TEXT,\n    CONSTRAINT fk_chat_messages\n        FOREIGN KEY (messageId)\n        REFERENCES ChatMessagesQueue(id)\n        ON DELETE CASCADE\n)");
                    }
                    if (j2 <= 77 && j3 > 77) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS OtpPurchases(\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    metadata TEXT NOT NULL,\n    paymentStatus TEXT NOT NULL,\n    orderId TEXT,\n    purchaseToken TEXT\n)");
                    }
                    if (j2 <= 78 && j3 > 78) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE SyncRevision ADD COLUMN triggeredFrom TEXT");
                    }
                    if (j2 <= 79 && j3 > 79) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS MixEditorStates (\n    revisionStamp TEXT PRIMARY KEY UNIQUE ON CONFLICT REPLACE,\n    state TEXT,\n    updateDate TEXT\n)");
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS MixEditorUiStates (\n    revisionStamp TEXT PRIMARY KEY UNIQUE ON CONFLICT REPLACE,\n    uiState TEXT,\n    updateDate INTEGER\n)");
                    }
                    if (j2 <= 80 && j3 > 80) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE ChatMessagesQueue ADD COLUMN errorText TEXT");
                    }
                    if (j2 <= 81 && j3 > 81) {
                        qd.f.p(gVar, (Integer) null, "DROP TABLE IF EXISTS midiroll_state_table");
                    }
                    if (j2 <= 82 && j3 > 82) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE MixEditorStates ADD COLUMN stateFile TEXT");
                    }
                    if (j2 <= 83 && j3 > 83) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE ChatMessagesQueue ADD COLUMN replyMessage TEXT");
                    }
                    if (j2 <= 84 && j3 > 84) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE SyncRevision ADD COLUMN origin TEXT");
                    }
                    if (j2 <= 85 && j3 > 85) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE SyncRevision ADD COLUMN metadata TEXT");
                    }
                    if (j2 <= 86 && j3 > 86) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS Settings (\n    userId TEXT NOT NULL,\n    key TEXT NOT NULL,\n    setting TEXT NOT NULL,\n    PRIMARY KEY (userId, key) ON CONFLICT REPLACE\n)");
                    }
                    if (j2 <= 87 && j3 > 87) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE Settings ADD COLUMN fileSettings TEXT DEFAULT NULL");
                    }
                    if (j2 <= 88 && j3 > 88) {
                        qd.f.p(gVar, (Integer) null, "ALTER TABLE OtpPurchases ADD COLUMN productId TEXT DEFAULT NULL");
                    }
                    if (j2 <= 90 && j3 > 90) {
                        qd.f.p(gVar, (Integer) null, "CREATE TABLE IF NOT EXISTS Tracks (\n    id TEXT PRIMARY KEY NOT NULL ON CONFLICT REPLACE,\n    post TEXT NOT NULL,\n    picture TEXT NOT NULL,\n    userId TEXT NOT NULL,\n    state TEXT NOT NULL,\n    plays INTEGER NOT NULL,\n    createdOn TEXT NOT NULL\n)");
                    }
                    qd.e.a.getClass();
                }
                qd.e.a.getClass();
                return;
            default:
                ((m) this.d).f(new yb.a(cVar), i, i2);
                return;
        }
    }

    public d(qd.a[] aVarArr) {
        super((int) 91, 2);
        this.d = aVarArr;
    }
}
