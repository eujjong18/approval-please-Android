package com.umc.approval.data.repository.approval

import com.umc.approval.data.dto.approval.get.*
import com.umc.approval.data.dto.approval.post.AgreeMyPostDto
import com.umc.approval.data.dto.approval.post.AgreePostDto
import com.umc.approval.data.dto.approval.post.LikeDto
import com.umc.approval.data.dto.upload.post.ApprovalUploadDto
import com.umc.approval.data.retrofit.instance.RetrofitInstance.ApprovalApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Query

/**
 * Approval Fragment Repository
 */
class ApprovalFragmentRepository {

    /**
     * 결재서류 목록 조회 API
     */
    fun getDocuments(category: String?=null, state: String?= null, sortBy: String?= null): Call<ApprovalPaperDto> {
        return ApprovalApi.getDocuments(category, state, sortBy)
    }

    /**
     * 관심부서 결재서류 목록 조회 API
     */
    fun getInterestingCategoryDocuments(accessToken: String, category: String?= null, state: String?= null, sortBy: String?= null): Call<ApprovalPaperDto> {
        return ApprovalApi.getInterestingCategoryDocuments(accessToken, category, state, sortBy)
    }

    /**
     * 결재서류 상세 조회 API
     */
    fun getDocumentDetail(documentId: String): Call<DocumentDto> {
        return ApprovalApi.getDocumentDetail(documentId)
    }

    /**
     * 결재서류 업로드 API
     */
    fun postDocument(accessToken: String, upload: ApprovalUploadDto): Call<ResponseBody> {
        return ApprovalApi.uploadDocument(accessToken, upload)
    }

    /**
     * 결재서류 업로드 API
     */
    fun deleteDocument(accessToken: String, documentId: String): Call<ResponseBody> {
        return ApprovalApi.deleteDocument(accessToken, documentId)
    }

    /**
     * 타 결재서류 승인 API
     */
    fun agreeDocument(accessToken: String, documentId: String, agreePostDto: AgreePostDto): Call<AgreeDto> {
        return ApprovalApi.agreeDocument(accessToken, documentId, agreePostDto)
    }

    /**
     * 내 결재서류 승인 API
     */
    fun agreeMyDocument(accessToken: String, agreeMyPostDto: AgreeMyPostDto): Call<ResponseBody> {
        return ApprovalApi.agreeMyDocument(accessToken, agreeMyPostDto)
    }

    /**
     * 관심부서 API
     */
    fun getCategory(accessToken: String): Call<InterestingDto> {
        return ApprovalApi.getMyCategory(accessToken)
    }


    /**
     * 내 결재서류 승인 API
     */
    fun like(accessToken: String, likeDto: LikeDto): Call<LikeReturnDto> {
        return ApprovalApi.like(accessToken, likeDto)
    }
}